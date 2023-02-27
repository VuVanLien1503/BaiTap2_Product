package manager.formatter;


import manager.model.Category;
import manager.service.my_impl.CategoryImpl;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ClassroomFormatter implements Formatter<Category> {
    private final CategoryImpl category;
    public ClassroomFormatter(CategoryImpl classroomService) {
        this.category=classroomService;
    }

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        return category.findById(Long.parseLong(text));
    }

    @Override
    public String print(Category object, Locale locale) {
        return null;
    }
}
