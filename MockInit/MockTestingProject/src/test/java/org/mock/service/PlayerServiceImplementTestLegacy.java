package org.mock.service;

import org.mock.IPlayerService;
import org.mock.IPlayerServiceImplement;
import org.mock.persistence.entity.Player;
import org.mock.persistence.entity.repository.IPlayerRepositoryImplement;

import static org.mockito.Mockito.*;

import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class PlayerServiceImplementTestLegacy {

    @Test
    public void testFindAll() {
        // GIVEN
        IPlayerRepositoryImplement playerRepository = mock(IPlayerRepositoryImplement.class);
        IPlayerService playerService = new IPlayerServiceImplement(playerRepository);
        //implementations el metodo when de mockito para simular el comportamiento del repositorio
        when(playerRepository.findAll()).thenReturn(DatabaseTest.playerListMock());

        // WHEN
        List<Player> players = playerService.findAll();

        // THEN
        assertNotNull(players);
        assertFalse(players.isEmpty());
        assertEquals(players.get(0).getName(), "Lionel Messi");

    }
}