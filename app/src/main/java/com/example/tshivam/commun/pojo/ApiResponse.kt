package com.example.tshivam.commun.pojo

import com.example.tshivam.commun.pojo.ItemsItem
import com.google.gson.annotations.SerializedName
data class ApiResponse(

	@field:SerializedName("total_count")
	val totalCount: Int? = null,

	@field:SerializedName("incomplete_results")
	val incompleteResults: Boolean? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem>? = null
)

