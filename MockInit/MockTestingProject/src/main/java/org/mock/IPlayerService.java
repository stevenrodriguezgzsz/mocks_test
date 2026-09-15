package org.mock;

import org.mock.persistence.entity.Player;

import java.util.List;

public interface giIPlayerService {
    List<Player> findAll();
    Player findById(Long id);
    void save(Player player);
    void deleteById(Long id);
}
