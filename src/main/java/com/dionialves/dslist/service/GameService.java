package com.dionialves.dslist.service;

import com.dionialves.dslist.dto.GameDTO;
import com.dionialves.dslist.dto.GameMinDTO;
import com.dionialves.dslist.entities.Game;
import com.dionialves.dslist.projections.GameMinProjection;
import com.dionialves.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService    {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();

        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> listGame = gameRepository.findAll();

        List<GameMinDTO> listGameDTO = listGame.stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
        return listGameDTO;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> listGame = gameRepository.searchByList(listId);

        List<GameMinDTO> listGameDTO = listGame.stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
        return listGameDTO;
    }
}
