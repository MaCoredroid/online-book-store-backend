package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.service.PurchaseProducerService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.errors.AuthorizationException;
import org.apache.kafka.common.errors.OutOfOrderSequenceException;
import org.apache.kafka.common.errors.ProducerFencedException;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class PurchaseProducerServiceimpl implements PurchaseProducerService {

    private Properties props = new Properties();
    private Producer<String, String> producer = null;
    public PurchaseProducerServiceimpl()
    {

        props.put("bootstrap.servers", "localhost:9092");
        props.setProperty("transactional.id", "my-transactional-id");
    }

    @Override
    public boolean Purchase(int CartID, String time) {
        try {
            producer = new KafkaProducer<String, String>(props, new StringSerializer(), new StringSerializer());
            producer.initTransactions();

            producer.beginTransaction();
            producer.send(new ProducerRecord<>("test", Integer.toString(CartID), time));
            producer.commitTransaction();
        } catch (ProducerFencedException | OutOfOrderSequenceException | AuthorizationException e) {
            producer.close();
            return false;
        } catch (KafkaException e) {
            producer.abortTransaction();
            return false;
        }
        producer.close();
        return true;
    }
}
