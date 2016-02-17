/**
 * ******************************************************************************
 * Copyright (c) 2016 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  *
 * Contributors:
 *     Kiel University - initial API and implementation
 *  ******************************************************************************
 */
package org.eclipse.elk.core.meta.metaData.impl;

import java.util.Collection;

import org.eclipse.elk.core.meta.metaData.MdAlgorithm;
import org.eclipse.elk.core.meta.metaData.MdCategory;
import org.eclipse.elk.core.meta.metaData.MdGraphFeature;
import org.eclipse.elk.core.meta.metaData.MdPropertySupport;
import org.eclipse.elk.core.meta.metaData.MetaDataPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Md Algorithm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.elk.core.meta.metaData.impl.MdAlgorithmImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.eclipse.elk.core.meta.metaData.impl.MdAlgorithmImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.elk.core.meta.metaData.impl.MdAlgorithmImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.eclipse.elk.core.meta.metaData.impl.MdAlgorithmImpl#getPreviewImage <em>Preview Image</em>}</li>
 *   <li>{@link org.eclipse.elk.core.meta.metaData.impl.MdAlgorithmImpl#getSupportedFeatures <em>Supported Features</em>}</li>
 *   <li>{@link org.eclipse.elk.core.meta.metaData.impl.MdAlgorithmImpl#getSupportedOptions <em>Supported Options</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MdAlgorithmImpl extends MdBundleMemberImpl implements MdAlgorithm
{
  /**
   * The cached value of the '{@link #getProvider() <em>Provider</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProvider()
   * @generated
   * @ordered
   */
  protected JvmTypeReference provider;

  /**
   * The default value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected static final String PARAMETER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected String parameter = PARAMETER_EDEFAULT;

  /**
   * The cached value of the '{@link #getCategory() <em>Category</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected MdCategory category;

  /**
   * The default value of the '{@link #getPreviewImage() <em>Preview Image</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreviewImage()
   * @generated
   * @ordered
   */
  protected static final String PREVIEW_IMAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPreviewImage() <em>Preview Image</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreviewImage()
   * @generated
   * @ordered
   */
  protected String previewImage = PREVIEW_IMAGE_EDEFAULT;

  /**
   * The cached value of the '{@link #getSupportedFeatures() <em>Supported Features</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupportedFeatures()
   * @generated
   * @ordered
   */
  protected EList<MdGraphFeature> supportedFeatures;

  /**
   * The cached value of the '{@link #getSupportedOptions() <em>Supported Options</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupportedOptions()
   * @generated
   * @ordered
   */
  protected EList<MdPropertySupport> supportedOptions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MdAlgorithmImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MetaDataPackage.Literals.MD_ALGORITHM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmTypeReference getProvider()
  {
    return provider;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProvider(JvmTypeReference newProvider, NotificationChain msgs)
  {
    JvmTypeReference oldProvider = provider;
    provider = newProvider;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetaDataPackage.MD_ALGORITHM__PROVIDER, oldProvider, newProvider);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProvider(JvmTypeReference newProvider)
  {
    if (newProvider != provider)
    {
      NotificationChain msgs = null;
      if (provider != null)
        msgs = ((InternalEObject)provider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetaDataPackage.MD_ALGORITHM__PROVIDER, null, msgs);
      if (newProvider != null)
        msgs = ((InternalEObject)newProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetaDataPackage.MD_ALGORITHM__PROVIDER, null, msgs);
      msgs = basicSetProvider(newProvider, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MetaDataPackage.MD_ALGORITHM__PROVIDER, newProvider, newProvider));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getParameter()
  {
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameter(String newParameter)
  {
    String oldParameter = parameter;
    parameter = newParameter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MetaDataPackage.MD_ALGORITHM__PARAMETER, oldParameter, parameter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MdCategory getCategory()
  {
    if (category != null && category.eIsProxy())
    {
      InternalEObject oldCategory = (InternalEObject)category;
      category = (MdCategory)eResolveProxy(oldCategory);
      if (category != oldCategory)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetaDataPackage.MD_ALGORITHM__CATEGORY, oldCategory, category));
      }
    }
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MdCategory basicGetCategory()
  {
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCategory(MdCategory newCategory)
  {
    MdCategory oldCategory = category;
    category = newCategory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MetaDataPackage.MD_ALGORITHM__CATEGORY, oldCategory, category));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPreviewImage()
  {
    return previewImage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPreviewImage(String newPreviewImage)
  {
    String oldPreviewImage = previewImage;
    previewImage = newPreviewImage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MetaDataPackage.MD_ALGORITHM__PREVIEW_IMAGE, oldPreviewImage, previewImage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MdGraphFeature> getSupportedFeatures()
  {
    if (supportedFeatures == null)
    {
      supportedFeatures = new EDataTypeEList<MdGraphFeature>(MdGraphFeature.class, this, MetaDataPackage.MD_ALGORITHM__SUPPORTED_FEATURES);
    }
    return supportedFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MdPropertySupport> getSupportedOptions()
  {
    if (supportedOptions == null)
    {
      supportedOptions = new EObjectContainmentEList<MdPropertySupport>(MdPropertySupport.class, this, MetaDataPackage.MD_ALGORITHM__SUPPORTED_OPTIONS);
    }
    return supportedOptions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MetaDataPackage.MD_ALGORITHM__PROVIDER:
        return basicSetProvider(null, msgs);
      case MetaDataPackage.MD_ALGORITHM__SUPPORTED_OPTIONS:
        return ((InternalEList<?>)getSupportedOptions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MetaDataPackage.MD_ALGORITHM__PROVIDER:
        return getProvider();
      case MetaDataPackage.MD_ALGORITHM__PARAMETER:
        return getParameter();
      case MetaDataPackage.MD_ALGORITHM__CATEGORY:
        if (resolve) return getCategory();
        return basicGetCategory();
      case MetaDataPackage.MD_ALGORITHM__PREVIEW_IMAGE:
        return getPreviewImage();
      case MetaDataPackage.MD_ALGORITHM__SUPPORTED_FEATURES:
        return getSupportedFeatures();
      case MetaDataPackage.MD_ALGORITHM__SUPPORTED_OPTIONS:
        return getSupportedOptions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MetaDataPackage.MD_ALGORITHM__PROVIDER:
        setProvider((JvmTypeReference)newValue);
        return;
      case MetaDataPackage.MD_ALGORITHM__PARAMETER:
        setParameter((String)newValue);
        return;
      case MetaDataPackage.MD_ALGORITHM__CATEGORY:
        setCategory((MdCategory)newValue);
        return;
      case MetaDataPackage.MD_ALGORITHM__PREVIEW_IMAGE:
        setPreviewImage((String)newValue);
        return;
      case MetaDataPackage.MD_ALGORITHM__SUPPORTED_FEATURES:
        getSupportedFeatures().clear();
        getSupportedFeatures().addAll((Collection<? extends MdGraphFeature>)newValue);
        return;
      case MetaDataPackage.MD_ALGORITHM__SUPPORTED_OPTIONS:
        getSupportedOptions().clear();
        getSupportedOptions().addAll((Collection<? extends MdPropertySupport>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MetaDataPackage.MD_ALGORITHM__PROVIDER:
        setProvider((JvmTypeReference)null);
        return;
      case MetaDataPackage.MD_ALGORITHM__PARAMETER:
        setParameter(PARAMETER_EDEFAULT);
        return;
      case MetaDataPackage.MD_ALGORITHM__CATEGORY:
        setCategory((MdCategory)null);
        return;
      case MetaDataPackage.MD_ALGORITHM__PREVIEW_IMAGE:
        setPreviewImage(PREVIEW_IMAGE_EDEFAULT);
        return;
      case MetaDataPackage.MD_ALGORITHM__SUPPORTED_FEATURES:
        getSupportedFeatures().clear();
        return;
      case MetaDataPackage.MD_ALGORITHM__SUPPORTED_OPTIONS:
        getSupportedOptions().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MetaDataPackage.MD_ALGORITHM__PROVIDER:
        return provider != null;
      case MetaDataPackage.MD_ALGORITHM__PARAMETER:
        return PARAMETER_EDEFAULT == null ? parameter != null : !PARAMETER_EDEFAULT.equals(parameter);
      case MetaDataPackage.MD_ALGORITHM__CATEGORY:
        return category != null;
      case MetaDataPackage.MD_ALGORITHM__PREVIEW_IMAGE:
        return PREVIEW_IMAGE_EDEFAULT == null ? previewImage != null : !PREVIEW_IMAGE_EDEFAULT.equals(previewImage);
      case MetaDataPackage.MD_ALGORITHM__SUPPORTED_FEATURES:
        return supportedFeatures != null && !supportedFeatures.isEmpty();
      case MetaDataPackage.MD_ALGORITHM__SUPPORTED_OPTIONS:
        return supportedOptions != null && !supportedOptions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (parameter: ");
    result.append(parameter);
    result.append(", previewImage: ");
    result.append(previewImage);
    result.append(", supportedFeatures: ");
    result.append(supportedFeatures);
    result.append(')');
    return result.toString();
  }

} //MdAlgorithmImpl