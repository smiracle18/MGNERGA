package com.proj.dao;

import java.util.List;

import com.proj.models.ProjectsBean;

public interface ProjectsDBLogic {
	
	
	public boolean createNewProject(ProjectsBean project);
	public ProjectsBean getProjectById(String projid);
	public List<ProjectsBean> getAllProjects();
	public List<ProjectsBean> getProjectsOfBlock(String block);
	public boolean deleteProject(String projid);
	public boolean updateStatus(String projid);



}
