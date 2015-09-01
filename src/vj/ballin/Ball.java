package vj.ballin;

import java.util.Random;

import redis.clients.jedis.Jedis;

public class Ball {
	Random rand = new Random();
	String antwoord = new String();
	public String question(String quest) {
		
	//Connecting to Redis server on localhost
    Jedis jedis = new Jedis("localhost");
    antwoord = jedis.get(quest);
    if(antwoord == null)
    {
    	jedis.set(quest, jedis.get("val" + rand.nextInt(20)));
    }
    //check whether server is running or not
    return jedis.get(quest);
	}
}
