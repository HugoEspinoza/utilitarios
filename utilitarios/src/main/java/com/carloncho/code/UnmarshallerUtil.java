package com.carloncho.code;

import java.io.StringReader;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;


public class UnmarshallerUtil<T> {

	private static final Logger LOGGER = Logger.getLogger(UnmarshallerUtil.class.getName());
	
    private T t = null;
    private static JAXBContext jaxbContext =null;

    @SuppressWarnings("rawtypes")
	private static ConcurrentHashMap mapa = new ConcurrentHashMap<Class, JAXBContext>();

    public UnmarshallerUtil(T obj)   {
        this.t = obj;
    }

    /**
     * Devuelve el objeto en base a una cadena XML. 
     * Si encuentra en el mapa con concurrencia una instancia de la misma clase lo devuelve, caso contrario instancia uno nuevo y lo almacena en el mapa.
     * */
    @SuppressWarnings("unchecked")
	public T xmlToObject(String message) throws JAXBException {

    	StringReader reader = new StringReader(message);	//Mantener para excepcion
    	
        if(mapa.containsKey(t.getClass())){
            jaxbContext = (JAXBContext) mapa.get(t.getClass());
            LOGGER.info("N vez");
            
        }else{
            jaxbContext = JAXBContext.newInstance(t.getClass());
            mapa.putIfAbsent(t.getClass(),jaxbContext);
            LOGGER.info("1ra vez");
        }

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        T object = (T)jaxbUnmarshaller.unmarshal(new StreamSource(reader));

        return object;
    }
}
