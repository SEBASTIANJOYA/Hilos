import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.*;

public class execution {

	public static void main(String[]args) throws FileNotFoundException {
		
		
		 JsonParser parser = new JsonParser();
	     FileReader fr = new FileReader("Enlaces.json");
	     JsonElement datos = parser.parse(fr);
	     dumpJSONElement(datos);
		
	}

	public static void dumpJSONElement(JsonElement elemento) {
		// TODO Auto-generated method stub
		
		  if (elemento.isJsonObject()) {
		        System.out.println("Es objeto");
		        JsonObject obj = elemento.getAsJsonObject();
		        java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
		        java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
		        while (iter.hasNext()) {
		            java.util.Map.Entry<String,JsonElement> entrada = iter.next();
		            System.out.println("Clave: " + entrada.getKey());
		            System.out.println("Valor:");
		            dumpJSONElement(entrada.getValue());
		        }
		 
		    } else if (elemento.isJsonArray()) {
		        JsonArray array = elemento.getAsJsonArray();
		        System.out.println("Es array. Numero de elementos: " + array.size());
		        java.util.Iterator<JsonElement> iter = array.iterator();
		        while (iter.hasNext()) {
		            JsonElement entrada = iter.next();
		            dumpJSONElement(entrada);
		        }
		    } else if (elemento.isJsonPrimitive()) {
		        System.out.println("Es primitiva");
		        JsonPrimitive valor = elemento.getAsJsonPrimitive();
		        if (valor.isBoolean()) {
		            System.out.println("Es booleano: " + valor.getAsBoolean());
		        } else if (valor.isNumber()) {
		            System.out.println("Es numero: " + valor.getAsNumber());
		        } else if (valor.isString()) {
		            System.out.println("Es texto: " + valor.getAsString());
		        }
		    } else if (elemento.isJsonNull()) {
		        System.out.println("Es NULL");
		    } else {
		        System.out.println("Es otra cosa");
		    }
		
	}
}
