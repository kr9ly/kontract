package dev.kr9ly.kontract

interface WithContract {

    val invariant: ContractContext.() -> Unit

    companion object {

        inline fun <T> WithContract.contract(
            body: () -> T
        ): T {
            return body().also {
                invariant(ContractContext)
            }
        }

        inline fun <T> WithContract.contract(
            input: ContractContext.() -> Unit,
            body: () -> T
        ): T {
            input(ContractContext)
            return body().also {
                invariant(ContractContext)
            }
        }

        inline fun <T> WithContract.contract(
            output: ContractContext.(T) -> Unit,
            body: () -> T
        ): T {
            return body().also {
                output(ContractContext, it)
                invariant(ContractContext)
            }
        }

        inline fun <T> WithContract.contract(
            input: ContractContext.() -> Unit,
            output: ContractContext.(T) -> Unit,
            body: () -> T
        ): T {
            input(ContractContext)
            return body().also {
                output(ContractContext, it)
                invariant(ContractContext)
            }
        }

        inline fun WithContract.contractUnit(
            body: () -> Unit
        ) {
            body()
            invariant(ContractContext)
        }

        inline fun WithContract.contractUnit(
            input: ContractContext.() -> Unit,
            body: () -> Unit
        ) {
            input(ContractContext)
            body()
            invariant(ContractContext)
        }
    }
}