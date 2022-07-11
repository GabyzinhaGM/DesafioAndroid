package br.com.zup.rickandmortyemsimcity.data

import  br.com.zup.rickandmortyemsimcity.data.RickAPI
import br.com.zup.rickandmortyemsimcity.data.model.APIResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitService {
    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"

        //Inicializarmos o Retrofit com suas configurações
        private val retrofit: Retrofit by lazy {

            //Configuração dos parametros de conexão
            val httpClient = OkHttpClient.Builder()
            httpClient.readTimeout(30, TimeUnit.SECONDS)
            httpClient.connectTimeout(30, TimeUnit.SECONDS)
            httpClient.writeTimeout(30, TimeUnit.SECONDS)

            //Cria o builder do Retrofit
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
        }

        @JvmStatic
        val apiService: RickAPI
            get() = retrofit.create(RickAPI::class.java)
    }
}