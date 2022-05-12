package NHLStore.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import NHLStore.config.StorageProperties;
import NHLStore.exception.StorageException;
import NHLStore.exception.StoreFileNotFoundException;
import NHLStore.service.StorageService;
@Service
public class StorageServiceImpl implements StorageService{
	private final Path rootLocation;
	@Override
	public String getStoredFilename(MultipartFile file,String id)
	{
		String ext=FilenameUtils.getExtension(file.getOriginalFilename());
		return "bhn"+id+"."+ext;
	}
	public StorageServiceImpl(StorageProperties properties) {
		this.rootLocation=Paths.get(properties.getLocation());
		
	}
	@Override
	public void store(MultipartFile file, String storedFilename) throws StorageException {
		try {
			if(file.isEmpty()) {
				throw new StorageException("Fail to store empty file");
			}
			Path destinationFile=this.rootLocation.resolve(Paths.get(storedFilename)).normalize().toAbsolutePath();
			if(!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
				throw new StorageException("Cannot store file outside current directory");
			}
			try(InputStream inputStream =file.getInputStream()){
				Files.copy(inputStream,destinationFile, StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (Exception e) {
			throw new StorageException("Failed to store file",e);
		}
	}
	@Override
	public Resource loadAsResource(String filename) throws StoreFileNotFoundException {
		try {
			Path file= load(filename);
			Resource resource=new UrlResource(file.toUri());
			if(resource.exists() || resource.isReadable()) {
				return resource;
			}
			throw new StoreFileNotFoundException("Could not read file: "+filename);
		} catch (Exception e) {
			throw new StoreFileNotFoundException("Could not read file: "+filename);
		}
	}
	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}
	@Override
	public void delete(String storedFilename) throws IOException {
		Path destinationFile=rootLocation.resolve(Paths.get(storedFilename)).normalize().toAbsolutePath();
		Files.delete(destinationFile);
	}
	@Override
	public void init() throws StorageException {
		try {
			Files.createDirectories(rootLocation);
			System.out.println(rootLocation.toString());
		} catch (Exception e) {
			throw new StorageException("Could not initialize storage",e);
		}
	}
}
