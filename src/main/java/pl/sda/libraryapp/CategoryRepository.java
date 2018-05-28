package pl.sda.libraryapp;

import java.io.IOException;
import java.util.List;

public class CategoryRepository {

    private static CategoryRepository categoryRepository = null;
    private static List<Category> categoryList;

    private CategoryRepository() {};

    public static CategoryRepository getInstance() throws IOException {
        if (categoryRepository == null) {
            ImportFile importFile = new ImportFile(RepositoryConfig.CATEGORIES_REPO_PATH_NAME);
            categoryList = importFile.parseInputFileAsCategoryList();
            return categoryRepository = new CategoryRepository();
        }
        return categoryRepository;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void addCategory(String name, int priority) {
        int id = categoryList.get(categoryList.size() - 1).getId() + 1;
        categoryList.add(new Category(id, name, priority));
    }
}
