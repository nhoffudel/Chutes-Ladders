package edu.udel.ckcamp.extremechutesandladders;
import junit.framework.TestCase;

public class ChutesAndLaddersTests extends TestCase {
	public static final Player[] playerList = {new Player('A', 1, false), new Player('B', 2, false)};
	public static final Space A = new Space('A');
	public static final Space B = new Space('B');
	public static final Space S = new Start();
	public static final Space F = new Finish();
	public static final Space C = new Chute();
	public static final Space L = new Ladder();
	public static final Space E = new Space('E');
	
	public static ChutesAndLaddersGame createStartGame() {
        // uses the make start game method on TicTacToe5x5Game
		return ChutesAndLaddersGame.makeStartGame(2, playerList);
    }
	
	public static ChutesAndLaddersGame createMidGame() {
		Space[][] board = new Space[][]
				{{E, E, C, E, E, E, E, C, E, F},
				{E, E, E, E, E, E, C, E, E, E},
				{L, E, E, E, E, E, E, E, E, E},
				{E, E, E, C, E, E, E, E, E, E},
				{E, C, E, E, E, E, E, E, E, L},
				{E, E, E, E, E, E, C, E, C, E},
				{E, E, A, E, L, E, E, E, E, E},
				{L, E, E, E, E, E, E, L, E, E},
				{E, E, B, E, C, E, E, E, E, E},
				{S, E, E, L, E, E, E, E, L, E}};
		ChutesAndLaddersGame game = new ChutesAndLaddersGame(board, 2, playerList);
		Player[] t = game.getTurnList();
		t[0].autoSetPosition(6, 2);
		t[1].autoSetPosition(8, 2);
		board[6][2].changeToOccupied();
		board[8][2].changeToOccupied();
		return game;
	}
	
	public static ChutesAndLaddersGame createMidGame2() {
		Space[][] board = new Space[][]
				{{E, E, C, E, E, E, E, C, E, F},
				{E, E, E, E, E, E, C, E, E, E},
				{L, E, E, E, E, E, E, E, E, E},
				{E, E, E, C, E, E, E, E, E, E},
				{E, C, E, E, E, E, E, E, E, L},
				{E, E, E, E, E, E, C, E, C, E},
				{E, E, E, E, L, E, E, E, E, E},
				{L, E, E, E, E, E, E, L, E, E},
				{E, E, E, E, C, E, B, E, E, E},
				{S, E, E, L, A, E, E, E, L, E}};
		ChutesAndLaddersGame game = new ChutesAndLaddersGame(board, 2, playerList);
		Player[] t = game.getTurnList();
		t[0].autoSetPosition(9, 4);
		t[1].autoSetPosition(8, 6);
		board[9][4].changeToOccupied();
		board[8][6].changeToOccupied();
		return game;
	}
	
	public static ChutesAndLaddersGame createMidGame3() {
		Space[][] board = new Space[][]
				{{E, E, C, E, E, E, E, C, E, F},
				{E, E, E, E, E, E, C, E, E, E},
				{L, E, E, E, E, E, E, E, E, E},
				{E, E, E, C, E, E, E, E, E, E},
				{E, C, E, E, E, E, E, E, E, L},
				{E, E, E, E, E, E, C, E, C, E},
				{E, E, E, E, L, E, E, E, E, E},
				{L, E, E, E, E, E, E, L, E, E},
				{E, E, E, E, C, E, E, E, E, E},
				{S, E, E, L, A, E, B, E, L, E}};
		ChutesAndLaddersGame game = new ChutesAndLaddersGame(board, 2, playerList);
		Player[] t = game.getTurnList();
		t[0].autoSetPosition(9, 4);
		t[1].autoSetPosition(9, 6);
		board[9][4].changeToOccupied();
		board[9][6].changeToOccupied();
		return game;
	}
	
	public static ChutesAndLaddersGame createMidGame4() {
		Space[][] board = new Space[][]
				{{E, E, C, E, E, E, E, C, E, F},
				{E, E, E, E, E, E, C, E, E, E},
				{L, E, E, E, E, E, E, E, E, E},
				{E, E, E, C, E, E, E, E, E, E},
				{E, C, E, E, E, E, E, E, E, L},
				{E, E, E, E, E, E, C, E, C, E},
				{E, E, E, E, L, E, E, E, E, A},
				{L, E, E, E, E, E, E, L, E, E},
				{E, E, E, E, C, E, E, E, E, E},
				{S, E, E, L, E, E, B, E, L, E}};
		ChutesAndLaddersGame game = new ChutesAndLaddersGame(board, 2, playerList);
		Player[] t = game.getTurnList();
		t[0].autoSetPosition(6, 9);
		t[1].autoSetPosition(9, 6);
		board[6][9].changeToOccupied();
		board[9][6].changeToOccupied();
		return game;
	}
	
	public static ChutesAndLaddersGame createMidGame5() {
		Space[][] board = new Space[][]
				{{E, E, C, E, E, E, E, C, E, F},
				{E, E, E, E, E, E, C, E, E, E},
				{L, E, E, E, E, E, E, E, E, E},
				{E, E, E, C, E, E, E, E, E, E},
				{E, C, E, E, E, E, E, E, E, L},
				{E, E, E, E, E, E, C, E, C, E},
				{E, E, E, E, L, E, E, E, E, E},
				{L, E, E, E, E, E, E, L, E, E},
				{E, E, A, E, C, E, E, E, E, E},
				{S, E, E, L, E, B, E, E, L, E}};
		ChutesAndLaddersGame game = new ChutesAndLaddersGame(board, 2, playerList);
		Player[] t = game.getTurnList();
		t[0].autoSetPosition(8, 2);
		t[1].autoSetPosition(9, 5);
		board[9][5].changeToOccupied();
		board[8][2].changeToOccupied();
		return game;
	}
	
	public static ChutesAndLaddersGame createMidGame6() {
		Space[][] board = new Space[][]
				{{E, E, C, E, E, E, E, C, A, F},
				{E, E, E, E, E, E, C, E, E, E},
				{L, E, E, E, E, E, E, E, E, E},
				{E, E, E, C, E, E, E, E, E, E},
				{E, C, E, E, E, E, E, E, E, L},
				{E, E, E, E, E, E, C, E, C, E},
				{E, E, E, E, L, E, E, E, E, E},
				{L, E, E, E, E, E, E, L, E, E},
				{E, E, E, E, C, E, E, E, E, E},
				{S, E, E, L, E, B, E, E, L, E}};
		ChutesAndLaddersGame game = new ChutesAndLaddersGame(board, 2, playerList);
		Player[] t = game.getTurnList();
		t[0].autoSetPosition(0, 8);
		t[1].autoSetPosition(9, 5);
		board[0][8].changeToOccupied();
		board[8][2].changeToOccupied();
		return game;
	}
	
	public static ChutesAndLaddersGame createEndGame() {
		Space[][] board = new Space[][]
				{{E, E, C, E, E, E, E, C, E, A},
				{E, E, E, E, E, E, C, E, E, E},
				{L, E, E, E, E, E, E, E, E, E},
				{E, E, E, C, E, B, E, E, E, E},
				{E, C, E, E, E, E, E, E, E, L},
				{E, E, E, E, E, E, C, E, C, E},
				{E, E, E, E, L, E, E, E, E, E},
				{L, E, E, E, E, E, E, L, E, E},
				{E, E, E, E, C, E, E, E, E, E},
				{S, E, E, L, E, E, E, E, L, E}};
		ChutesAndLaddersGame game = new ChutesAndLaddersGame(board, 2, playerList);
		Player[] t = game.getTurnList();
		t[0].autoSetPosition(0, 9);
		t[1].autoSetPosition(3, 5);
		board[0][9].changeToOccupied();
		board[3][5].changeToOccupied();
		return game;		
	}
	
	
	public static takeTurnAction createAction() {
		Cards a = new Cards();
		a.setCard(0);
		return new takeTurnAction(new Player('A', 1, false), 1);
	}
	
	public static takeTurnAction createAction2() {
		Cards a = new Cards();
		a.setCard(0);
		return new takeTurnAction(new Player('A', 1, false), 0);
	}
	
//	public static takeTurnAction createAction3() {
//		Cards a = new Cards();
//		a.setCard(0);
//		return new takeTurnAction(new Player('A', 1, false), 1, a);
//	}
	
	public static void main(String[] args) {
        // print some games and sample actions
        System.out.println(createStartGame().toString());
        System.out.println(createMidGame().toString());
        System.out.println(createEndGame().toString());
        System.out.println(createAction().toString());
    }
	
	public void test_changeTurn() {
        ChutesAndLaddersGame game = createStartGame();
        Player[] p = game.getTurnList();
        assertEquals(p[0].getName(), game.getTurn());
        game.changeTurn();
        assertEquals(p[1].getName(), game.getTurn());
        game.changeTurn();
        assertEquals(p[0].getName(), game.getTurn());
    }
	
	public void test_takeTurnAction() {
		takeTurnAction action1 = createAction();
		ChutesAndLaddersGame game1 = createMidGame2();
		Player[] t = game1.getTurnList();
		assertEquals(5, t[0].getSpaceNumber());
		assertEquals(17, t[1].getSpaceNumber());
		
		action1.update(game1);
		System.out.print(game1.toString());
		assertEquals(7, t[0].getSpaceNumber());
		
		action1.update(game1);
		System.out.print(game1.toString());
		assertEquals(7, t[0].getSpaceNumber());
		assertEquals(19, t[1].getSpaceNumber());
		
		ChutesAndLaddersGame game3 = createMidGame3();
		System.out.print(game3.toString());
		action1.update(game3);
		System.out.print(game3.toString());
		assertEquals(7, t[0].getSpaceNumber());
		assertEquals(6, t[1].getSpaceNumber());
	}
	
	public void test_chutes() {
		takeTurnAction action1 = createAction();
		ChutesAndLaddersGame game2 = createMidGame();
		game2.changeTurn();
		Player[] t = game2.getTurnList();
		
		action1.update(game2);
		assertEquals(33, t[0].getSpaceNumber());
		assertEquals(6, t[1].getSpaceNumber());
		
		ChutesAndLaddersGame game5 = createMidGame5();
		action1.update(game5);
		assertEquals(5, t[0].getSpaceNumber());
		assertEquals(6, t[1].getSpaceNumber());
	}
	
	public void test_ladders() {
		takeTurnAction action1 = createAction();
		ChutesAndLaddersGame game2 = createMidGame2();
		Player[] t = game2.getTurnList();
		
		action1.update(game2);
		game2.changeTurn();
		action1.update(game2);
		assertEquals(40, t[0].getSpaceNumber());
		assertEquals(17, t[1].getSpaceNumber());
		
		ChutesAndLaddersGame game3 = createMidGame4();
		Player[] t2 = game3.getTurnList();
		game3.changeTurn();
		action1.update(game3);
		System.out.println(game3.toString());
		assertEquals(40, t2[0].getSpaceNumber());
		assertEquals(39, t2[1].getSpaceNumber());
		
	}
	
	public void test_isEnd() {
        assertFalse(createStartGame().isEnd());
        assertFalse(createMidGame().isEnd());
        assertTrue(createEndGame().isEnd());
        
        ChutesAndLaddersGame game6 = createMidGame6();
        takeTurnAction action1 = createAction();
        takeTurnAction action2 = createAction2();
        
        assertFalse(game6.isEnd());
        action1.update(game6);
        assertTrue(game6.isEnd());
        
        game6 = createMidGame6();
        action2.update(game6);
        assertTrue(game6.isEnd());
    }

	
}
