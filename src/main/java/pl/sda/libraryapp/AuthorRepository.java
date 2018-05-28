package pl.sda.libraryapp;


import java.io.IOException;
import java.util.List;

    public class AuthorRepository {
        private static AuthorRepository authorRepository = null;
        private static List<Author> authorList;

        private AuthorRepository(){};

        public static AuthorRepository getInstance() throws IOException {

            if(authorRepository == null){
                ImportFile importFile = new ImportFile(RepositoryConfig.AUTHORS_REPO_PATH_NAME);
                authorList = importFile.parseInputFileAsAuthorList();
                return authorRepository = new AuthorRepository();
            }
            return authorRepository;
        }

        public List<Author> getAuthorList(){
            return authorList;
        }

        public void addAuthor(String name, int age){
            int id = authorList.get(authorList.size() - 1).getId() + 1;
            authorList.add(new Author(id, name, age));
        }
}
