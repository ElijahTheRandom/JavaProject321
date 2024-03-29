package dummy;

import tagifyme.model.Database;
import tagifyme.model.Data;
import tagifyme.model.Tag;
import tagifyme.model.Relationship;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Optional;

public class DummyData {
  private final static int tagSz  = 20;
  private final static int dataSz = 100;
  private final static int relSz  = 100;

  // Initialize a Database with dummy data.
  public static Database init() {
    List<Tag> tagList  = new ArrayList();
    List<Data> dataList = new ArrayList();
    List<Relationship> relList = new ArrayList();

    for (int i = 0; i < dataSz; i++) {
      dataList.add(new Data(String.format("Data%d", i)));
    }

    for (int i = 0; i < tagSz; i++) {
      tagList.add(new Tag(String.format("Tag%d", i)));
    }

    Random rand = new Random(321);

    for (int i = 0; i < relSz; i++) {
      int dataIdx = rand.nextInt(dataSz);
      int tagIdx  = rand.nextInt(tagSz);
      relList.add(new Relationship(dataList.get(dataIdx), tagList.get(tagIdx)));
    }

    return new Database(Optional.of(dataList), Optional.of(tagList), Optional.of(relList));
  } 
}
