package com.anisimov.domain.usecase

import com.anisimov.data.MainRepository
import com.anisimov.data.entity.BlogPost

interface FetchBlogPostsUseCase {
    suspend operator fun invoke(): List<BlogPost>
}

class FetchBlogPostsUseCaseImpl(private val repository: MainRepository) : FetchBlogPostsUseCase {
    override suspend operator fun invoke(): List<BlogPost> {
        return repository.getBlogPosts()
    }
}