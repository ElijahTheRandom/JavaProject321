package tagifyme.dummy;

import tagifyme.model.Database;
import tagifyme.model.Data;
import tagifyme.model.Tag;
import tagifyme.model.Relationship;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class DummyData {
    // Initialize a Database with dummy data.
    public static Database init() {
        List<Tag> genreList = new ArrayList<>();
        List<Data> bookList = new ArrayList<>();
        List<Relationship> relList = new ArrayList<>();

        // Hard-coding ten books with specific titles
        bookList.add(new Data("To Kill a Mockingbird"));   // Historical Fiction, Southern Gothic
        bookList.add(new Data("1984"));                    // Dystopian
        bookList.add(new Data("The Great Gatsby"));        // Historical Fiction
        bookList.add(new Data("Pride and Prejudice"));     // Romance, Satire
        bookList.add(new Data("The Catcher in the Rye"));  // Literary Fiction
        bookList.add(new Data("The Lord of the Rings"));   // Fantasy, Adventure
        bookList.add(new Data("Harry Potter and the Sorcerer's Stone")); // Fantasy, Young Adult
        bookList.add(new Data("The Chronicles of Narnia")); // Fantasy, Children's Literature
        bookList.add(new Data("Animal Farm"));             // Political Satire, Allegory
        bookList.add(new Data("Jane Eyre"));               // Gothic Novel, Romance

        // Define genres
        String[] genres = {"Historical Fiction", "Southern Gothic", "Dystopian", "Romance", "Satire",
                           "Literary Fiction", "Fantasy", "Adventure", "Young Adult", "Children's Literature",
                           "Political Satire", "Allegory", "Gothic Novel"};
        for (int i = 0; i < genres.length; i++) {
            genreList.add(new Tag(genres[i]));
        }

        // Map books to their genres
        relList.add(new Relationship(bookList.get(0), genreList.get(0)));
        relList.add(new Relationship(bookList.get(0), genreList.get(1)));
        relList.add(new Relationship(bookList.get(1), genreList.get(2)));
        relList.add(new Relationship(bookList.get(2), genreList.get(0)));
        relList.add(new Relationship(bookList.get(3), genreList.get(3)));
        relList.add(new Relationship(bookList.get(3), genreList.get(4)));
        relList.add(new Relationship(bookList.get(4), genreList.get(5)));
        relList.add(new Relationship(bookList.get(5), genreList.get(6)));
        relList.add(new Relationship(bookList.get(5), genreList.get(7)));
        relList.add(new Relationship(bookList.get(6), genreList.get(6)));
        relList.add(new Relationship(bookList.get(6), genreList.get(8)));
        relList.add(new Relationship(bookList.get(7), genreList.get(6)));
        relList.add(new Relationship(bookList.get(7), genreList.get(9)));
        relList.add(new Relationship(bookList.get(8), genreList.get(10)));
        relList.add(new Relationship(bookList.get(8), genreList.get(11)));
        //relList.add(new Relationship(bookList.get(9), genreList.get(3)));
        //relList.add(new Relationship(bookList.get(9), genreList.get(12)));

        return new Database(Optional.of(bookList), Optional.of(genreList), Optional.of(relList));
    }
}
