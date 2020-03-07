package com.proj.dao;

import java.util.List;

import com.proj.models.BlocksBean;

public interface BlockDBLogic {
	public List<BlocksBean>  getAllBlocks();
	public boolean insertBlock(BlocksBean block);

	

}
