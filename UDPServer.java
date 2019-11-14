package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ���ն�
 * 1��ʹ��DatagramSocket ָ���˿ڣ��������նˡ�
 * 2��׼����������װ��DatagramPacket����
 * 3������ʽ���հ���
 * 4����������
 * 5���ͷ���Դ
 * 
 * @author dell
 *
 */

public class UDPServer {
	public static void main(String[] args) throws Exception {
		System.out.println("���շ�������....");
		//ʹ��DatagramSocket ָ���˿ڣ��������ն�
		DatagramSocket server=new DatagramSocket(9999);
		//׼����������װ��DatagramPacket����
		byte[] datas=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(datas,0,datas.length);
		//����ʽ���հ���
		server.receive(packet);
		//��������
		byte[] b=packet.getData();
		System.out.println(new String(b));
		//�ͷ���Դ
		server.close();
		
	}

}
