package org.mock.service;

import org.mock.persistence.entity.Player;
import org.mock.persistence.entity.repository.IPlayerRepositoryImplement;

import java.util.List;

public class IPlayerServiceImplement implements IPlayerService {
    private IPlayerRepositoryImplement playerRepository;

    public IPlayerServiceImplement(IPlayerRepositoryImplement playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findAll() {
        return this.playerRepository.findAll();
    }

    @Override
    public Player findById(Long id) {
        return this.playerRepository.findById(id);
    }

    @Override
    public void save(Player player) {
        this.playerRepository.save(player);

    }

    @Override
    public void deleteById(Long id) {
        this.playerRepository.deleteById(id);


    }
}
