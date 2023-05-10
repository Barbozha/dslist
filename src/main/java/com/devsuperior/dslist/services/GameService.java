package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		//Devolve uma lista de objetos
		List<Game> result = gameRepository.findAll();
		//Converte cada objeto encontrado para GameMinDTO
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true) //import org.springframework.transaction.annotation.Transactional
	public GameDTO findById(Long id){
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}
	
	
}
