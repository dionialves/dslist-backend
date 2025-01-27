package com.dionialves.dslist.controllers;

import com.dionialves.dslist.dto.GameDTO;
import com.dionialves.dslist.dto.GameListDTO;
import com.dionialves.dslist.dto.GameMinDTO;
import com.dionialves.dslist.service.GameListService;
import com.dionialves.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }
}
