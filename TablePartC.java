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

    public static void main(String[] args) throws IOException {
        String line = null;
	String fileName = "input.csv";
	    
        Configuration config = HBaseConfiguration.create();
        String table_name = "powers";
        HTable hTable = new HTable(config, table_name);
        int i = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            while ((line = reader.readLine()) != null) {
                String[] country = line.split(",");
                Put p = new Put(Bytes.toBytes(country[0]));
                i++;
                p.add(Bytes.toBytes("personal"), Bytes.toBytes("hero"), Bytes.toBytes(country[1]));
                p.add(Bytes.toBytes("personal"), Bytes.toBytes("power"), Bytes.toBytes(country[2]));

                p.add(Bytes.toBytes("professional"), Bytes.toBytes("name"), Bytes.toBytes(country[3]));
                p.add(Bytes.toBytes("professional"), Bytes.toBytes("xp"), Bytes.toBytes(country[4]));

                p.add(Bytes.toBytes("custom"), Bytes.toBytes("color"), Bytes.toBytes(country[5]));

                hTable.put(p);
            }

        }

        hTable.close();   
   }
}

