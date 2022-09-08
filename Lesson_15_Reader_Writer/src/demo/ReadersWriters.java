package demo;

public interface ReadersWriters
{
  int safeRead();
  void write();
  void acquireRead();
  void releaseRead();
  void acquireWrite();
  void releaseWrite();
}
