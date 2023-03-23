package com.bookstore.bookstoreapi.Controllers;

import com.bookstore.bookstoreapi.Entities.BookBrowsingEntity;
import com.bookstore.bookstoreapi.Entities.Wishlist;
import com.bookstore.bookstoreapi.Entities.WishlistedBook;
import com.bookstore.bookstoreapi.Repositories.BookBrowsingRepository;
import com.bookstore.bookstoreapi.Repositories.WishlistRepository;
import com.bookstore.bookstoreapi.Repositories.WishlistedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/wishlist")
public class WishlistController {

    @Autowired
    WishlistRepository wishlistRepo;

    @Autowired
    WishlistedBookRepository wishlistedBookRepo;

    @Autowired
    BookBrowsingRepository bookBrowsingRepo;

    @PostMapping("/create")
    public String createWishlist(@RequestBody Wishlist newWishlist) {
        if(newWishlist.getWishlist_name().trim().isEmpty()){
            return "Wishlist name cannot be empty";
        }
        if(newWishlist.getUserId() == null || newWishlist.getUserId() == 0){
            return "Invalid user";
        }

        List<Wishlist> wishlists = wishlistRepo.getAllByUserId(newWishlist.getUserId());

        if(wishlists.size() >= 3){
            return "User already has 3 wishlists";
        }

        wishlistRepo.save(newWishlist);
        return "Wishlist " + newWishlist.getWishlist_name() + " was created successfully...";
    }

    @PostMapping("/add-book")
    public String addBookToWishlist(@RequestBody WishlistedBook newWishlistedBook){
        if(newWishlistedBook.getWishlistId() == null || newWishlistedBook.getWishlistId() == 0){
            return "Wishlist ID is invalid";
        }
        if(newWishlistedBook.getBookId() == null && newWishlistedBook.getBookId() == 0){
            return "Book ID is invalid";
        }

        BookBrowsingEntity selectedBook = bookBrowsingRepo.findById(newWishlistedBook.getBookId()).get();
        Wishlist selectedWishlist = wishlistRepo.findById(newWishlistedBook.getWishlistId()).get();

        wishlistedBookRepo.save(newWishlistedBook);
        return selectedBook.getName() + " was added to wishlist: " + selectedWishlist.getWishlist_name() + " successfully...";

    }

    @DeleteMapping("/remove-book")
    public String removeBookFromWishlist(@RequestBody WishlistedBook wishlistedBook){
        if(wishlistedBook.getWishlistId() == null || wishlistedBook.getWishlistId() == 0){
            return "Wishlist ID is invalid";
        }
        if(wishlistedBook.getBookId() == null && wishlistedBook.getBookId() == 0){
            return "Book ID is invalid";
        }

        WishlistedBook wishlistedBookToRemove = wishlistedBookRepo.getWishlistedBookByWishlistIdAndBookId(wishlistedBook.getWishlistId(), wishlistedBook.getBookId());
        wishlistedBookRepo.deleteById(wishlistedBookToRemove.getId());
        return "Your book was removed from your wishlist successfully...";
    }

    @GetMapping("/{id}")
    public List<BookBrowsingEntity> getAllBooksFromWishlist(@PathVariable(value = "id") Integer wishlist_id){
        List<WishlistedBook> allBooks = wishlistedBookRepo.getAllBywishlistId(wishlist_id);
        List<BookBrowsingEntity> books = new ArrayList<>();
        allBooks.forEach(book -> {

            books.add(bookBrowsingRepo.findById(book.getId()).get());
        });
        return books;
    }
}
