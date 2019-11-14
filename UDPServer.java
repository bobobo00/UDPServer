package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端
 * 1，使用DatagramSocket 指定端口，创建接收端。
 * 2，准备容器，封装成DatagramPacket包裹
 * 3，阻塞式接收包裹
 * 4，分析数据
 * 5，释放资源
 * 
 * @author dell
 *
 */

public class UDPServer {
	public static void main(String[] args) throws Exception {
		System.out.println("接收方启动中....");
		//使用DatagramSocket 指定端口，创建接收端
		DatagramSocket server=new DatagramSocket(9999);
		//准备容器，封装成DatagramPacket包裹
		byte[] datas=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(datas,0,datas.length);
		//阻塞式接收包裹
		server.receive(packet);
		//分析数据
		byte[] b=packet.getData();
		System.out.println(new String(b));
		//释放资源
		server.close();
		
	}

}
