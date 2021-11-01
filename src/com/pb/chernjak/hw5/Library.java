package com.pb.chernjak.hw5;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[3];
        books[0] = new Book("Энциклопедия", "Бернар Вербер", 2010);
        books[1] = new Book("Приключения", "А.Дюма", 2000);
        books[2] = new Book("Словарь", "В.Даль", 1996);

        Reader[] readers = new Reader[3];
        readers[0] = new Reader("Иванов И.И.", 252410, "Журналистика", "15.10.2000", "0505555555");
        readers[1] = new Reader("Петров П.П.", 173664, "МЭО","01.01.1981","0505556666");
        readers[2] = new Reader("Жан Беленюк", 199885, "Физическое воспитание","07.05.1991","0505559999");

        for (int i = 0; i < books.length; ++i){
            System.out.println(books[i].getInfo());
        }
        System.out.println();

        for (int i = 0; i < readers.length; ++i){
            System.out.println(readers[i].getInfo());
        }
        System.out.println();

        readers[1].takeBook(Book.getBookCount());
        readers[2].takeBook(books[1].getName(), books[2].getName(), books[0].getName());
        readers[0].takeBook(books[1], books[2], books[0]);
        System.out.println();

        readers[0].returnBook(Book.getBookCount());
        readers[1].returnBook(books[1].getName(), books[2].getName(), books[0].getName());
        readers[2].returnBook(books[1], books[2], books[0]);
    }
}
