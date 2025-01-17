package com.test.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class SerializationDemonstrator {

	public static void serialize(final Object objectToSerialize,
			final String name) throws IOException {
		if (name == null) {
			throw new IllegalArgumentException(
					"Name of file to which to serialize object to cannot be null.");
		}
		if (objectToSerialize == null) {
			throw new IllegalArgumentException(
					"Object to be serialized cannot be null.");
		}

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(name);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(objectToSerialize);
			System.out.println("Serialization of Object " + objectToSerialize
					+ " completed.");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			if (fos != null)
				fos.close();
			if (oos != null)
				oos.close();
		}

	}

	public static Object deserialize(final Class classBeingDeserialized,
			final String fileToDeserialize) throws IOException {
		if (fileToDeserialize == null) {
			throw new IllegalArgumentException(
					"Cannot deserialize from a null filename.");
		}
		if (classBeingDeserialized == null) {
			throw new IllegalArgumentException(
					"Type of class to be deserialized cannot be null.");
		}

		Object objectOut = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileToDeserialize);
			ois = new ObjectInputStream(fis);
			objectOut = ois.readObject();
			System.out.println("Deserialization of Object " + objectOut
					+ " is completed.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				fis.close();
			if (ois != null)
				ois.close();
		}

		return objectOut;

	}

	public static void main(String[] args) throws IOException {
		String fileName = "Employee.txt";
		String finalName = "";
		String workingDir = System.getProperty("user.dir");
		finalName = workingDir + "\\" + fileName;
		/*serialize("Prashant Kumar", finalName);
		String name = (String) deserialize(String.class, finalName);
		System.out.println(name);*/
		final Person personIn = new Person("Flintstone", "Fred", new CityState("Bedrock", "Cobblestone"));
		SerializationDemonstrator.serialize(personIn, finalName);

		final Person personOut = (Person) SerializationDemonstrator.deserialize( Person.class,finalName);
		System.out.println(personOut);
	}

}

  class Person implements Serializable {
	private String lastName;
	private String firstName;
	private CityState cityAndState;

	public Person(){}
	public Person(final String newLastName, final String newFirstName,
			final CityState newCityAndState) {
		this.lastName = newLastName;
		this.firstName = newFirstName;
		this.cityAndState = newCityAndState;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " of "
				+ this.cityAndState;
	}
}


/*class SerializablePerson implements Serializable {
	private String lastName;
	private String firstName;
	private CityState cityAndState;


	public SerializablePerson(final String newLastName, final String newFirstName,
			final CityState newCityAndState) {
		this.lastName = newLastName;
		this.firstName = newFirstName;
		this.cityAndState = newCityAndState;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " of "
				+ this.cityAndState;
	}

	private void writeObject(final ObjectOutputStream out) throws IOException {
		out.writeUTF(this.lastName);
		out.writeUTF(this.firstName);
		out.writeUTF(this.cityAndState.getCityName());
		out.writeUTF(this.cityAndState.getStateName());
	}

	private void readObject(final ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		this.lastName = in.readUTF();
		this.firstName = in.readUTF();
		this.cityAndState = new CityState(in.readUTF(),in.readUTF());
	}

	private void readObjectNoData() throws ObjectStreamException {
		throw new InvalidObjectException("Stream data required");
	}
	
}
*/

//class CityState extends Person {
class CityState implements Serializable{
	private final String cityName;
	private final String stateName;

	public CityState(final String newCityName, final String newStateName) {
		this.cityName = newCityName;
		this.stateName = newStateName;
	}

	public String getCityName() {
		return this.cityName;
	}

	public String getStateName() {
		return this.stateName;
	}

	@Override
	public String toString() {
		return this.cityName + ", " + this.stateName;
	}
}
