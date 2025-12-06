package backend.base

interface Controllers {
    val auth get() = AuthController()
}