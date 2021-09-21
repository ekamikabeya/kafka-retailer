package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import models.Sale;
import serializers.SaleSerializer;

public class SaleGenerator {
		private static Random rand = new Random();
		private static long operationId = 0;
		private static BigDecimal ticketValue = BigDecimal.valueOf(500);
		
		private static Sale getSale() {
			long client = rand.nextLong();
			int quantity = rand.nextInt(10);
			Sale sale = new Sale(
					operationId++,
					client,
					quantity,
					ticketValue.multiply(BigDecimal.valueOf(quantity)));	
			return sale;
		}
		
		static class Customer{
			private String name;
			private int age;

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public void setAge(int age) {
				this.age = age;
			}
			
			public Customer(String name, int age) {
				super();
				this.name = name;
				this.age = age;
			}

			@Override
			public String toString() {
				return "Customer [name=" + name + ", age=" + age + "]";
			}
			
			
		}
		
		public static void main(String[]  args) throws InterruptedException {
			List<Integer> list = new ArrayList<>();
			list.add(4);
		    System.out.println(list.contains(5));
		    System.out.println(list.indexOf(5)); // returns -1
		    System.out.println(list.indexOf(4)); // returns 0
		    
		    List<Customer> customers = new ArrayList<>();
		    customers.add(new SaleGenerator.Customer("Peter", 10));
		    customers.add(new SaleGenerator.Customer("Bob", 20));
		    
		    System.out.println(customers.indexOf(new SaleGenerator.Customer("Bob", 20))); //-1
		    
		    Customer peter = customers
		    		.stream()
		    		.filter(customer -> customer.getName() == "Peter")
		    		.findAny()
		    		.orElse(null);
		    peter.setAge(0);
		    
		    customers.forEach(customer -> System.out.println(customer));
			/*
			Properties properties = new Properties();
		    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, SaleSerializer.class.getName());
		    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, SaleSerializer.class.getName());
		    
		    try(KafkaProducer<String, Sale> producer = new KafkaProducer<String, Sale>(properties)) {
		    	while(true) {
		    		Sale sale = getSale(); 
		    		ProducerRecord<String, Sale> record = new ProducerRecord<String, Sale>("venda-ingressos", sale);
		    		producer.send(record);	
		    		
		    		Thread.sleep(100);
		    	}
		    	
		    	
		    }
		    */
		}

}
