package Soccer_Match;

public class Start
{
  public static void main(String[] args)
  {
    SoccerMatch soccerMatch = new SoccerMatch();
    DreamTeamFan dreamTeamFan = new DreamTeamFan();
    soccerMatch.addPropertyChangeListener(dreamTeamFan);
    soccerMatch.startMatch();

    OldBoysFan oldBoysFan = new OldBoysFan();
    Referee referee = new Referee();
    //AngryCoach angryCoach = new AngryCoach(0);
    AngryCoach angryCoach1 = new AngryCoach(1);
    ScoreBoard scoreBoard = new ScoreBoard();
    Medic medic = new Medic();

    soccerMatch.addPropertyChangeListener(scoreBoard);
    soccerMatch.addPropertyChangeListener(oldBoysFan);
    //soccerMatch.addPropertyChangeListener(angryCoach);
    soccerMatch.addPropertyChangeListener(angryCoach1);
    soccerMatch.addPropertyChangeListener(referee);
    soccerMatch.addPropertyChangeListener(medic);


  }
}
