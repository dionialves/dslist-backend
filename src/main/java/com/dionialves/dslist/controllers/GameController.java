package com.dionialves.dslist.controllers;

import com.dionialves.dslist.dto.GameMinDTO;
import com.dionialves.dslist.entities.Game;
import com.dionialves.dslist.repositories.GameRepository;
import com.dionialves.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        return gameService.findAll();
    }
}
