package org.mock.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mock.IPlayerServiceImplement;
import org.mock.persistence.entity.Player;
import org.mock.persistence.entity.repository.IPlayerRepositoryImplement;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
    class PlayerServiceImplementTest {

    @Mock
    private IPlayerRepositoryImplement playerRepository;
    @InjectMocks
    private IPlayerServiceImplement playerService;

    @Test
    public void testFindAll() {
        // GIVEN
        //implementations el metodo when de mockito para simular el comportamiento del repositorio
        when(playerRepository.findAll()).thenReturn(DatabaseTest.playerListMock());
        // WHEN
        List<Player> players = playerService.findAll();

        // THEN
        assertEquals(players.get(0).getName(), "Lionel Messi");

    }
    @Test
    public void testFindById() {
        // GIVEN
        Long playerId = 20L;
        when(playerRepository.findById(anyLong())).thenReturn(DatabaseTest.findByIdMock(playerId));

        // WHEN
        Player player = playerService.findById(playerId);

        // THEN
        assertNotNull(player);
        assertEquals(player.getName(), "Lionel Messi");
        verify(this.playerRepository).findById(playerId);
    }

    @Test
    public void testSave() {
        //GIVEN
        Player newPlayer =DatabaseTest.newPlayerMock();

        //WHEN
        this.playerRepository.save(newPlayer);

        //THEN
        verify(this.playerRepository).save(any(Player.class));
    }

    @Test
    public void testDeleteById() {
        long id = 1L;
        this.playerService.deleteById(2l);
        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        verify(this.playerRepository).deleteById(anyLong());
        verify(this.playerRepository).deleteById(captor.capture());
        assertEquals(id, captor.getValue());
    }

}
