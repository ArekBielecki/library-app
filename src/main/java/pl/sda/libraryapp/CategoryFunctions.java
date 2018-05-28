package pl.sda.libraryapp;

import java.io.IOException;
import java.util.List;

public class CategoryFunctions {
    private CategoryRepository categoryRepository;
    private RepositorySaver repositorySaver;
    private List<Category> categoryList;

    public CategoryFunctions(CategoryRepository categoryRepository, RepositorySaver repositorySaver) {
        this.categoryRepository = categoryRepository;
        this.repositorySaver = repositorySaver;

        categoryList = categoryRepository.getCategoryList();
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void addNewCategory(String name, int priority) throws IOException {
        categoryRepository.addCategory(name, priority);
        repositorySaver.addCategoryToRepositoryFile(getCategoryList());
    }



    public boolean isCategoryInRepository(int categoryId) {
        return categoryList.stream()
                .filter(x -> x.getId() == categoryId)
                .findAny().isPresent();
    }

    public Category getCategoryById(int categoryId){
        return categoryList.stream()
                .filter(x -> x.getId() == categoryId).findAny().get();
    }
}
