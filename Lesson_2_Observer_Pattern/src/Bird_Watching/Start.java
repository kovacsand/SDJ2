package Bird_Watching;

public class Start
{
  public static void main(String[] args)
  {
    Bird bird = new Bird();
    BirdWatcher birdWatcher = new BirdWatcher();
    BlindBirdWatcher blindBirdWatcher = new BlindBirdWatcher();

    bird.addPropertyChangeListener(birdWatcher);
    bird.addPropertyChangeListener(blindBirdWatcher);

    bird.live();
  }
}
