package com.macoredroid.onlinebookstore.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@NodeEntity
public class Friend {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Friend() {
        // Empty constructor required as of Neo4j API 2.0.5
    };

    public Friend(String name) {
        this.name = name;
    }

    /**
     * Neo4j doesn't REALLY have bi-directional relationships. It just means when querying
     * to ignore the direction of the relationship.
     * https://dzone.com/articles/modelling-data-neo4j
     */
    @Relationship(type = "TEAMMATE", direction = Relationship.UNDIRECTED)
    public Set<Friend> friends;

    public void beFriendWith(Friend friend) {
        if (friends == null) {
            friends = new HashSet<>();
        }
        friends.add(friend);
    }

    public String toString() {

        return this.name + "'s teammates => "
                + Optional.ofNullable(this.friends).orElse(
                Collections.emptySet()).stream()
                .map(Friend::getName)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
