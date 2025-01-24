package com.dionialves.dslist.service;

import com.dionialves.dslist.dto.GameMinDTO;
import com.dionialves.dslist.entities.Game;
import com.dionialves.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService    {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> listGame = gameRepository.findAll();

        List<GameMinDTO> listGameDTO = listGame.stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
        return listGameDTO;
    }
}
