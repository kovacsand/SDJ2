package client.views;

import client.core.ViewHandler;
import client.core.ViewModelFactory;

public interface ViewController
{
  void init(ViewModelFactory vmf, ViewHandler vh);
}
