package org.mock;

import org.mock.persistence.entity.Player;
import org.mock.persistence.entity.repository.IPlayerRepositoryImplement;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   public static void main(String[] args) {
        IPlayerRepositoryImplement playerRepository = new IPlayerRepositoryImplement();
        IPlayerService playerService = new IPlayerServiceImplement(playerRepository);

        // Find all players
        List<Player> players = playerService.findAll();
        System.out.println("All Players:");
        players.forEach(System.out::println);
       System.out.println("-------jugandor numero 1 ------------------");
       System.out.println(playerService.findById(1l));




   }
}