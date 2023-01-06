import com.example.cflow_project_nikenfebi.Member.Apimember.memberdata
import com.example.cflow_project_nikenfebi.Member.Apimember.memberitem
import retrofit2.Response
import retrofit2.http.*

interface memberApi {
    @GET("/rest/v1/Members?select=*")
    suspend fun get2(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String
    ) : Response<List<memberitem>>

    @POST("/rest/v1/Members?select=*")
    suspend fun create2(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String,
        @Body memberdata: memberdata
    )

    @DELETE("/rest/v1/Members?select=*")
    suspend fun delete2(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String,
        @Query("id") idQuery : String
    ) : Response<Unit>
}