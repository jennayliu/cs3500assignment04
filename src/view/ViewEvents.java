package view;

public interface ViewEvents {
  void saveEvent(String name, String path);
  void loadEvent(String name);
  void brightenEvent(int amount);
}
