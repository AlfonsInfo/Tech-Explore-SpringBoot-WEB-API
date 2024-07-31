//package group.bootcamp.technicaltest.common.messagebroker;
//
//public class ProducerRabbitMq {
//
//    public void produceMessage(){
//        //* creating a connection
//        val factory =  ConnectionFactory();
//        factory.setUri("amqp://guest:guest@localhost:5672/")
//        factory.virtualHost  = "/"
//        val connection : Connection = factory.newConnection()
//        val channel = connection.createChannel()
//
//        val deliverCallback = DeliverCallback { consumerTag: String, message: Delivery ->
//                println(String(message.body))
//            println(message.envelope.routingKey)
//        }
//
//        val cancelCallBack = CancelCallback{ consumerTag ->
//                println("Consumer Cancelled")
//        }
//
//        channel.basicConsume("whatsapp",true,deliverCallback,cancelCallBack)
//
//
//        //channel.close()
//        //connection.close()
//
//        //closing connection
//    }
//}
