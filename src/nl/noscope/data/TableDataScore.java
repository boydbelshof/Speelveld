package nl.noscope.data;

/**
 * @author Bas
 * De TableDataScore class houd de strings vast
 * voor het opmaken van de tabel game_scores.
 */

import android.provider.BaseColumns;

public class TableDataScore {
	
	public TableDataScore()
	{
		
	}
	
	public static abstract class TableInfoScore implements BaseColumns
	{
		public static final String PLAYER_lEVEL = "player_level";
		public static final String PLAYER_SCORE = "player_score";
		public static final String DATABASE_NAME = "game_info";
		public static final String TABLE_NAME = "game_scores";
	}
}
