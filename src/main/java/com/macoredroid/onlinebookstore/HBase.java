package com.macoredroid.onlinebookstore;

import com.google.protobuf.ServiceException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class HBase {
    //获取配置信息
    public static Configuration conf;

    static{
        conf = HBaseConfiguration.create();
    }

    //1.判断一张表是否存在
    public static boolean isExist(String tableName){
        //对表操作需要使用HbaseAdmin
        try {

            Connection connection = ConnectionFactory.createConnection(conf);
            //管理表

            HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();


            return admin.tableExists(TableName.valueOf(tableName));
        } catch (IOException  e) {
            e.printStackTrace();
        }
        return false;
    }

    //2.在hbase创建表
    public static void createTable(String tableName, String... columnfamily){
        try {
            //对表操作需要使用HbaseAdmin
            Connection connection = ConnectionFactory.createConnection(conf);
            //管理表
            HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();

            //1.表如果存在，请输入其他表名
            if(isExist(tableName)){

                System.out.println("表存在，请输入其他表名");
            }else{
                //2.注意:创建表的话，需要创建一个描述器

                HTableDescriptor htd = new HTableDescriptor(TableName.valueOf(tableName));

                //3.创建列族
                for(String cf:columnfamily){
                    htd.addFamily(new HColumnDescriptor(cf));
                }

                //4.创建表
                admin.createTable(htd);
                System.out.println("表已经创建成功！");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void addFile(){
        try {
            //对表操作需要使用HbaseAdmin
            System.out.println("Call HBase Once!");
            StringBuilder contentBuilder = new StringBuilder();
            try (Stream<String> stream = Files.lines( Paths.get("log.txt"), StandardCharsets.UTF_8))
            {
                stream.forEach(s -> contentBuilder.append(s).append("\n"));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            String tableName="log";
            String cf="info";
            String column="content";
            String rowkey="";
            int count=scanAll(tableName);
            if(count==3)
            {
                deleteRow(tableName,"101",cf);
                rowkey="101";
            }
            else if(count==2)
            {
                rowkey="103";
            }
            else if(count==1)
            {
                rowkey="102";
            }
            else if(count==0)
            {
                rowkey="101";
            }
            Connection connection = ConnectionFactory.createConnection(conf);
            Table t = connection.getTable(TableName.valueOf(tableName));
            //1.表如果存在，请输入其他表名
            if (!isExist(tableName)) {
                createTable(tableName,cf);
            } else {
                //2.用put方式加入数据
                Put p = new Put(Bytes.toBytes(rowkey));
                //3.加入数据
                p.addColumn(Bytes.toBytes(cf),Bytes.toBytes(column),Bytes.toBytes(contentBuilder.toString()));
                t.put(p);

            }
            File file = new File("log.txt");

            if(file.delete())
            {
                System.out.println("Write Once!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //5.删除表中一行数据
    public static void deleteRow(String tableName, String rowkey, String cf ){
        try {
            //对表操作需要使用HbaseAdmin
            Connection connection = ConnectionFactory.createConnection(conf);
            Table t = connection.getTable(TableName.valueOf(tableName));
            //1.表如果存在，请输入其他表名
            if (!isExist(tableName)) {
                System.out.println("表不存在");
            } else {
                //1.根据rowkey删除数据
                Delete delete = new Delete(Bytes.toBytes(rowkey));
                //2.删除
                t.delete(delete);
                System.out.println("删除成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //7.扫描表数据 scan全表扫描
    public static int scanAll(String tableName){
        try {
            //对表操作需要使用HbaseAdmin
            Connection connection = ConnectionFactory.createConnection(conf);
            if (!isExist(tableName)) {
                return 0;
            }
            Table t = connection.getTable(TableName.valueOf(tableName));

            //1.实例scan
            Scan s = new Scan();
            //2.拿到Scanner对象
            ResultScanner rs = t.getScanner(s);
            int ret=0;
            //3.遍历
            for (Result r:rs){
                Cell[] cells = r.rawCells();
                //遍历具体数据
                for (Cell c : cells){
                    ret++;
                }
            }
            return ret;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


}


