package travel.common.solutions.utils.xml.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;

public class StaxReader implements AutoCloseable {
    private XMLStreamReader reader = null;
    private FileInputStream fileInputStream;

    private StaxReader() {
    }

    public static StaxReader newInstance(String file) throws Exception {
        StaxReader instance = new StaxReader();
        instance.fileInputStream = new FileInputStream(new File(file));
        instance.reader = XMLInputFactory.newInstance().createXMLStreamReader(instance.fileInputStream);
        return instance;
    }

    @Override
    public void close() throws Exception {
        if(reader != null){
            reader.close();
        }

        if(fileInputStream != null){
            fileInputStream.close();
        }
    }

    public XMLStreamReader getReader(){
        return reader;
    }
}
