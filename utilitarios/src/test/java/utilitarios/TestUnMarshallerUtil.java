package utilitarios;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.carloncho.code.FileUtil;
import com.carloncho.code.UnmarshallerUtil;
import com.carloncho.code.bean.MensajeInformativo;


public class TestUnMarshallerUtil {

	private static final Logger logger = Logger.getLogger(TestUnMarshallerUtil.class.getName());
	
	private static String mensajeTagUno;
	private static String mensajeTagDos;
	
	@BeforeClass
    public static void obtenerDataParaPruebas() {

		try {
			
			File archivoMI1 = FileUtil.getFileFromResources("mensajeInformativo/MI1.xml");
			File archivoMI2 = FileUtil.getFileFromResources("mensajeInformativo/MI2.xml");
			
			mensajeTagUno = FileUtil.xmlToStringFromFile(archivoMI1);
			mensajeTagDos = FileUtil.xmlToStringFromFile(archivoMI2);
			
		} catch (IOException | IllegalArgumentException e) {
			logger.error(e);
		}
		
    }	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void UnMarshallOptimizadoCasoExitoso() {
		
		UnmarshallerUtil unmarshallerUtil = new UnmarshallerUtil(new MensajeInformativo());
		
        try {
        	
			MensajeInformativo mensajeInformativoUno = (MensajeInformativo) unmarshallerUtil.xmlToObject(mensajeTagUno);
			logger.info("[mensajeInformativoUno]:" + mensajeInformativoUno);
			
			MensajeInformativo mensajeInformativoDos = (MensajeInformativo) unmarshallerUtil.xmlToObject(mensajeTagDos);
			logger.info("[mensajeInformativoDos]:" + mensajeInformativoDos);
			
		} catch (Exception e) {
			logger.error(e);
		}
		
	}
}
