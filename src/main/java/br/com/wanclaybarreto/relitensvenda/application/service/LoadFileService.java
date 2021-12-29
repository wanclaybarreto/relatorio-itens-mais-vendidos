package br.com.wanclaybarreto.relitensvenda.application.service;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.wanclaybarreto.relitensvenda.util.IOUtils;

@Service
public class LoadFileService {
	
	@Value("${relitensvenda.files.itensvenda.relatorios}")
	private String dirRelatoriosItensVenda;
	
	public byte[] getBytes(String type, String fileName) {
		
		try {
			
			String dir;
			
			if ("relatorioItensVenda".equals(type)) {
				dir = dirRelatoriosItensVenda;
			} else {
				throw new Exception(type + " não é um tipo de arquivo válido!");
			}
			
			return IOUtils.getBytes(Paths.get(dir, fileName));
			
		} catch (Exception e) {
			
			throw new LoadFileServiceException(e);
			
		}
		
	}
	
}
