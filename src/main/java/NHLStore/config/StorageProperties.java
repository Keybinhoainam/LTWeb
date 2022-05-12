package NHLStore.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@ConfigurationProperties("storage")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class StorageProperties {
	private String location;
	public StorageProperties() {
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

	


	
	
}
