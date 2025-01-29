package com.dionialves.dslist.service;

import com.dionialves.dslist.dto.GameDTO;
import com.dionialves.dslist.dto.GameListDTO;
import com.dionialves.dslist.dto.GameMinDTO;
import com.dionialves.dslist.entities.Game;
import com.dionialves.dslist.entities.GameList;
import com.dionialves.dslist.projections.GameMinProjection;
import com.dionialves.dslist.repositories.GameListRepository;

import com.dionialves.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.get(sourceIndex);
        list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
