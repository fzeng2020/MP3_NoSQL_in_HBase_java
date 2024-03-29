import java.io.IOException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;

import org.apache.hadoop.hbase.TableName;

import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

import org.apache.hadoop.hbase.util.Bytes;

public class TablePartC{

   public static void main(String[] args) throws IOException {

	   //TODO
       Configuration config = HBaseConfiguration.create();
       String tablename = "powers";
       HTable table = new HTable(config, tablename);
       String line = "";
           
       String inputfile = "input.csv";
       try (BufferedReader br = new BufferedReader(new FileReader(inputfile))) {

           while ((line = br.readLine()) != null){
               String[] newvalue = line.split(",");
               Put p = new Put(Bytes.toBytes(newvalue[0]));

               p.add(Bytes.toBytes("personal"),
                       Bytes.toBytes("hero"),Bytes.toBytes(newvalue[1]));

               p.add(Bytes.toBytes("personal"),
                       Bytes.toBytes("power"),Bytes.toBytes(newvalue[2]));

               p.add(Bytes.toBytes("professional"),Bytes.toBytes("name"),
                       Bytes.toBytes(newvalue[3]));

               p.add(Bytes.toBytes("professional"),Bytes.toBytes("xp"),
                       Bytes.toBytes(newvalue[4]));

               p.add(Bytes.toBytes("custom"),Bytes.toBytes("color"),
                       Bytes.toBytes(newvalue[5]));

               table.put(p);
           }
           
		   
       }catch(IOException e){
           e.printStackTrace();
       }

       table.close();

   }
}
