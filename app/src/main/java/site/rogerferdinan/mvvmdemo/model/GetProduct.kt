package site.rogerferdinan.mvvmdemo.model

data class GetProduct(
    val isFound: Int,
    val message: List<Product>
)