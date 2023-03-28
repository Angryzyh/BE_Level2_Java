package Iterable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// 迭代器
public class Iterator_ {

	@Test
	@DisplayName("迭代list集合")
	void 迭代list集合() {
		List<Book> books = new ArrayList<>();
		/*books.add(new Book("三国演义", "罗贯中", 29.99));
		books.add(new Book("小李飞刀", "古龙", 39.98));
		books.add(new Book("红楼梦", "曹雪芹", 34.50));*/
		Collections.addAll(
			books,
			new Book("三国演义", "罗贯中", 29.99),
			new Book("小李飞刀", "古龙", 39.98),
			new Book("红楼梦", "曹雪芹", 34.50)
		);

		// Iterator迭代器 遍历元素
		Iterator<Book> iterator = books.iterator();
		while (iterator.hasNext()) {
			Book next = iterator.next();
			System.out.println("next = " + next);
		}

		//增强for循环就是 Iterator的简写形式
		for (Book book : books) {
			System.out.println("book = " + book);
		}
	}
}

@Data
@Accessors(chain = true)
@FieldNameConstants
@NoArgsConstructor
@AllArgsConstructor
class Book {
	private String name;
	private String author;
	private Double price;
}

